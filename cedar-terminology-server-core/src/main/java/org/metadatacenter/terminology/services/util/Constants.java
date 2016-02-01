package org.metadatacenter.terminology.services.util;

/**
 * Constants of general utility.
 *
 * All member of this class are immutable.
 */
public class Constants
{

  /** BioPortal API endpoints */
  public static final String BP_API_BASE = "http://data.bioontology.org/";
  public static final String BP_SEARCH_BASE_URL = BP_API_BASE + "search";
  public static final String BP_PROVISIONAL_CLASSES_BASE_URL = BP_API_BASE + "provisional_classes/";

  /** BioPortal Search endpoint - Search scopes */
  public static final String BP_SEARCH_SCOPE_ALL = "all";
  public static final String BP_SEARCH_SCOPE_CLASSES = "classes";
  public static final String BP_SEARCH_SCOPE_VALUE_SETS = "value_sets";
  public static final String BP_SEARCH_SCOPE_VALUES = "values";

  // PRIVATE //

  /**
   The caller references the constants using Constants.EMPTY_STRING,
   and so on. Thus, the caller should be prevented from constructing objects of
   this class, by declaring this private constructor.
   */
  private Constants()
  {
    // This restricts instantiation
    throw new AssertionError();
  }
}
