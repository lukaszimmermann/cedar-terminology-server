package org.metadatacenter.terminology;

import org.metadatacenter.terminology.bioportal.domainObjects.SearchResults;
import org.metadatacenter.terminology.bioportal.domainObjects.ValueSet;
import org.metadatacenter.terminology.bioportal.domainObjects.ValueSets;
import org.metadatacenter.terminology.bioportal.domainObjects.Values;
import org.metadatacenter.terminology.bioportal.domainObjects2.custom.OntologyClass;

import java.io.IOException;
import java.util.List;

public interface ITerminologyService
{
//  SearchResults search(String q, List<String> scope, List<String> sources, int page, int pageSize, boolean displayContext,
//    boolean displayLinks, String apiKey) throws IOException;
//
//  /** TODO:
//   * - Get all ontologies
//   * - Get ontology details
//   * - Get ontology size
//   * - Get ontology categories
//   * - Get class details / and value set details
//   * - Get class tree
//   * - Get class children
//   * - Get class parents
//   * - Get ontology tree root
//   * - Get ontology classes
//   */
//
  /** Classes **/
  OntologyClass createClass(OntologyClass c, String apiKey) throws IOException;
//  OntologyClass findClass(String id, String apiKey) throws IOException;
//  List<OntologyClass> findAllProvisionalClasses(String ontology, String apiKey) throws IOException;
//  // TODO: This call is pending (to be released by the BioPortal team first)
//  OntologyClass updateClass(OntologyClass c, String apiKey) throws IOException;
//  // TODO: This call is pending (to be released by the BioPortal team first)
//  void deleteClass(String classId, String apiKey) throws IOException;
//
//  /** Relations **/
//  Relation createRelation(Relation relation, String apiKey) throws IOException;
//  Relation findRelation(String id, String apiKey) throws IOException;
//  // TODO: This call is pending (to be released by the BioPortal team first)
//  Relation deleteRelation(String id, String apiKey) throws IOException;
//
//  /** Value sets **/
//  ValueSet createValueSet(ValueSet vs, String apiKey) throws IOException;
//  ValueSet findValueSet(String id, String apiKey) throws IOException;
//  ValueSets findValueSetsByVsCollection(String vsCollection, String apiKey) throws IOException;
//  // TODO: This call does not support provisional classes yet
//  Values findValuesByValueSet(String vsId, String vsCollection, String apiKey) throws IOException;

  // TODO:
  // - Update value set- Delete value set

  /** Value set items **/
  // TODO:
  //  - Create a Value Set Item
  //  - Retrieve value set item by id
  //  - Update value set item
  //  - Delete value set item
}
