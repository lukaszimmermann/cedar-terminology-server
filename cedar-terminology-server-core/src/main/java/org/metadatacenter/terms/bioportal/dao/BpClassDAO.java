package org.metadatacenter.terms.bioportal.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.metadatacenter.terms.bioportal.customObjects.BpPagedResults;
import org.metadatacenter.terms.bioportal.domainObjects.BpClass;
import org.metadatacenter.terms.bioportal.domainObjects.BpTreeNode;
import org.metadatacenter.terms.util.Constants;
import org.metadatacenter.terms.util.Util;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BpClassDAO
{
  private final int connectTimeout;
  private final int socketTimeout;

  public BpClassDAO(int connectTimeout, int socketTimeout)
  {
    this.connectTimeout = connectTimeout;
    this.socketTimeout = socketTimeout;
  }

  public BpClass find(String id, String ontology, String apiKey) throws HTTPException, IOException {
    String url = Constants.BP_ONTOLOGIES_BASE_URL + ontology + "/" + Constants.BP_CLASSES + id;
    HttpResponse response = Request.Get(url)
        .addHeader("Authorization", Util.getBioPortalAuthHeader(apiKey)).
            connectTimeout(connectTimeout).socketTimeout(socketTimeout).execute().returnResponse();

    int statusCode = response.getStatusLine().getStatusCode();
    // The class was successfully retrieved
    if (statusCode == 200) {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode bpResult = mapper.readTree(new String(EntityUtils.toByteArray(response.getEntity())));
      return mapper.convertValue(bpResult, BpClass.class);
    } else {
      throw new HTTPException(statusCode);
    }
  }

  public List<BpTreeNode> getTree(String id, String ontology, String apiKey) throws IOException {
    String url = Constants.BP_ONTOLOGIES_BASE_URL + ontology + "/" + Constants.BP_CLASSES + id + "/tree";
    HttpResponse response = Request.Get(url)
        .addHeader("Authorization", Util.getBioPortalAuthHeader(apiKey)).
            connectTimeout(connectTimeout).socketTimeout(socketTimeout).execute().returnResponse();

    int statusCode = response.getStatusLine().getStatusCode();
    // The tree was successfully retrieved
    if (statusCode == 200) {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode bpResult = mapper.readTree(new String(EntityUtils.toByteArray(response.getEntity())));
      List<BpTreeNode> nodes = new ArrayList<>();
      for (JsonNode n : bpResult) {
        nodes.add(mapper.convertValue(n, BpTreeNode.class));
      }
      return nodes;
    } else {
      throw new HTTPException(statusCode);
    }
  }

  public BpPagedResults<BpClass> getChildren(String id, String ontology, String apiKey) throws IOException
  {
    String url = Constants.BP_ONTOLOGIES_BASE_URL + ontology + "/" + Constants.BP_CLASSES + id + "/children";
    HttpResponse response = Request.Get(url)
        .addHeader("Authorization", Util.getBioPortalAuthHeader(apiKey)).
            connectTimeout(connectTimeout).socketTimeout(socketTimeout).execute().returnResponse();
    int statusCode = response.getStatusLine().getStatusCode();
    // Success
    if (statusCode == 200) {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode bpResult = mapper.readTree(new String(EntityUtils.toByteArray(response.getEntity())));
      return mapper.readValue(mapper.treeAsTokens(bpResult), new TypeReference<BpPagedResults<BpClass>>() {});
    } else {
      throw new HTTPException(statusCode);
    }
  }

  public List<BpClass> getParents(String id, String ontology, String apiKey) throws IOException
  {
    String url = Constants.BP_ONTOLOGIES_BASE_URL + ontology + "/" + Constants.BP_CLASSES + id + "/parents";
    HttpResponse response = Request.Get(url)
        .addHeader("Authorization", Util.getBioPortalAuthHeader(apiKey)).
            connectTimeout(connectTimeout).socketTimeout(socketTimeout).execute().returnResponse();
    int statusCode = response.getStatusLine().getStatusCode();
    // Success
    if (statusCode == 200) {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode bpResult = mapper.readTree(new String(EntityUtils.toByteArray(response.getEntity())));
      List<BpClass> children = new ArrayList<>();
      for (JsonNode n : bpResult) {
        children.add(mapper.convertValue(n, BpClass.class));
      }
      return children;
    } else {
      throw new HTTPException(statusCode);
    }
  }

  public BpPagedResults<BpClass> findValueSetsByValueSetCollection(String vsCollection, String apiKey)
    throws IOException
  {
    HttpResponse response = Request.Get(Constants.BP_SEARCH_BASE_URL +
      "?also_search_provisional=true&valueset_roots_only=true&ontology_types=VALUE_SET_COLLECTION&ontologies="
      + vsCollection).addHeader("Authorization", Util.getBioPortalAuthHeader(apiKey)).
      connectTimeout(connectTimeout).socketTimeout(socketTimeout).execute().returnResponse();

    int statusCode = response.getStatusLine().getStatusCode();
    // Success
    if (statusCode == 200) {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode bpResult = mapper.readTree(new String(EntityUtils.toByteArray(response.getEntity())));
      return mapper.readValue(mapper.treeAsTokens(bpResult), new TypeReference<BpPagedResults<BpClass>>() {});
    } else {
      throw new HTTPException(statusCode);
    }
  }

  public BpPagedResults<BpClass> findValuesByValueSet(String vsId, String vsCollection, String apiKey)
    throws IOException
  {
    String url = Constants.BP_ONTOLOGIES_BASE_URL + vsCollection + "/classes/" + vsId + "/children";
    HttpResponse response = Request.Get(url).addHeader("Authorization", Util.getBioPortalAuthHeader(apiKey)).
      connectTimeout(connectTimeout).socketTimeout(socketTimeout).execute().returnResponse();

    int statusCode = response.getStatusLine().getStatusCode();
    // Success
    if (statusCode == 200) {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode bpResult = mapper.readTree(new String(EntityUtils.toByteArray(response.getEntity())));
      return mapper.readValue(mapper.treeAsTokens(bpResult), new TypeReference<BpPagedResults<BpClass>>() {});
    } else {
      throw new HTTPException(statusCode);
    }
  }


}