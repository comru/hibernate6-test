package com.test.model;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "json_entity")
public class JsonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JdbcTypeCode(SqlTypes.JSON)
    private String jsonStr;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> jsonCollection;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> jsonMap;

    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode jsonNode;

    @JdbcTypeCode(SqlTypes.JSON)
    private PojoClass jsonPojo;

    @JdbcTypeCode(SqlTypes.JSON)
    private Set<PojoClass> jsonPojoCollection;

    public String getJsonStr() {
        return jsonStr;
    }

    public JsonEntity setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
        return this;
    }

    public List<String> getJsonCollection() {
        return jsonCollection;
    }

    public JsonEntity setJsonCollection(List<String> jsonCollection) {
        this.jsonCollection = jsonCollection;
        return this;
    }

    public Map<String, String> getJsonMap() {
        return jsonMap;
    }

    public JsonEntity setJsonMap(Map<String, String> jsonMap) {
        this.jsonMap = jsonMap;
        return this;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public JsonEntity setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
        return this;
    }

    public PojoClass getJsonPojo() {
        return jsonPojo;
    }

    public JsonEntity setJsonPojo(PojoClass jsonPojo) {
        this.jsonPojo = jsonPojo;
        return this;
    }

    public Set<PojoClass> getJsonPojoCollection() {
        return jsonPojoCollection;
    }

    public JsonEntity setJsonPojoCollection(Set<PojoClass> jsonPojoCollection) {
        this.jsonPojoCollection = jsonPojoCollection;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}