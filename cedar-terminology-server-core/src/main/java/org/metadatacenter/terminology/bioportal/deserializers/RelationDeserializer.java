package org.metadatacenter.terminology.bioportal.deserializers;

//public class RelationDeserializer extends JsonDeserializer<Relation>
//{
//  @Override
//  public Relation deserialize(JsonParser parser, DeserializationContext ctx) throws IOException
//  {
//    JsonNode node = parser.getCodec().readTree(parser);
//
//    String id = (node.get("@id") != null) ? node.get("@id").asText() : null;
//    String source = (node.get("source") != null) ? node.get("source").asText() : null;
//    String relationType = (node.get("relationType") != null) ? node.get("relationType").asText() : null;
//    String targetClassId = (node.get("targetClassId") != null) ? node.get("targetClassId").asText() : null;
//    String targetClassOntology = (node.get("targetClassOntology") != null) ? node.get("targetClassOntology").asText() : null;
//
//    return new Relation(id, source, relationType, targetClassId, targetClassOntology);
//  }
//}
