package org.metadatacenter.terminology.services.bioportal.domainObjects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.metadatacenter.terminology.services.bioportal.deserializers.ValueSetsDeserializer;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = ValueSetsDeserializer.class)
public class ValueSets
{

  private int page;
  private int pageCount;
  private int pageSize;
  private int prevPage;
  private int nextPage;
  private List<ValueSet> valueSets = new ArrayList<>();

  public ValueSets(int page, int pageCount, int pageSize, int prevPage, int nextPage,
    List<ValueSet> valueSets)
  {
    this.page = page;
    this.pageCount = pageCount;
    this.pageSize = pageSize;
    this.prevPage = prevPage;
    this.nextPage = nextPage;
    this.valueSets = valueSets;
  }

  public int getPage()
  {
    return page;
  }

  public void setPage(int page)
  {
    this.page = page;
  }

  public int getPageCount()
  {
    return pageCount;
  }

  public void setPageCount(int pageCount)
  {
    this.pageCount = pageCount;
  }

  public int getPageSize()
  {
    return pageSize;
  }

  public void setPageSize(int pageSize)
  {
    this.pageSize = pageSize;
  }

  public int getPrevPage()
  {
    return prevPage;
  }

  public void setPrevPage(int prevPage)
  {
    this.prevPage = prevPage;
  }

  public int getNextPage()
  {
    return nextPage;
  }

  public void setNextPage(int nextPage)
  {
    this.nextPage = nextPage;
  }

  public List<ValueSet> getValueSets()
  {
    return valueSets;
  }

  public void setValueSets(List<ValueSet> valueSets)
  {
    this.valueSets = valueSets;
  }
}
