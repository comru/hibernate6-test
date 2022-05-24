package com.test.model;

import com.test.model.type.BitSetJavaType;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.type.NumericBooleanConverter;
import org.hibernate.type.SqlTypes;
import org.hibernate.type.TrueFalseConverter;
import org.hibernate.type.YesNoConverter;

import java.net.InetAddress;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.BitSet;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    private PojoClass json;

    @JdbcTypeCode(SqlTypes.SQLXML)
    private Map<String, String> xml;

    private ZoneOffset zoneOffset;
    private InetAddress inetAddress;

    @JavaType(BitSetJavaType.class)
    @Column(name = "bit_set_attr")
    private BitSet bitSetAttr;

    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "zonedDateTime_zoneOffset")
    private ZonedDateTime zonedDateTime;

    @TimeZoneStorage(TimeZoneStorageType.AUTO)
    private OffsetDateTime offsetDateTime;

    @CurrentTimestamp( timing = GenerationTiming.ALWAYS )
    public Instant lastUpdatedAt;

    @Convert(converter = NumericBooleanConverter.class)
    @Column(name = "numeric_boolean")
    private Boolean numericBoolean;

    @Convert(converter = TrueFalseConverter.class)
    @Column(name = "true_false_bool")
    private Boolean trueFalseBool;

    @Convert(converter = YesNoConverter.class)
    @Column(name = "yes_no_bool")
    private Boolean yesNoBool;

    @Column(name = "simple_bool")
    private Boolean simpleBool;


    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public PojoClass getJson() {
        return json;
    }

    public Customer setJson(PojoClass json) {
        this.json = json;
        return this;
    }

    public Map<String, String> getXml() {
        return xml;
    }

    public Customer setXml(Map<String, String> xml) {
        this.xml = xml;
        return this;
    }

    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public Customer setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
        return this;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public Customer setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
        return this;
    }

    public BitSet getBitSetAttr() {
        return bitSetAttr;
    }

    public Customer setBitSetAttr(BitSet bitSetAttr) {
        this.bitSetAttr = bitSetAttr;
        return this;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public Customer setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
        return this;
    }

    public OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    public Customer setOffsetDateTime(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
        return this;
    }

    public Instant getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public Customer setLastUpdatedAt(Instant lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }

    public Boolean getNumericBoolean() {
        return numericBoolean;
    }

    public Customer setNumericBoolean(Boolean numericBoolean) {
        this.numericBoolean = numericBoolean;
        return this;
    }

    public Boolean getTrueFalseBool() {
        return trueFalseBool;
    }

    public Customer setTrueFalseBool(Boolean trueFalseBool) {
        this.trueFalseBool = trueFalseBool;
        return this;
    }

    public Boolean getYesNoBool() {
        return yesNoBool;
    }

    public Customer setYesNoBool(Boolean yesNoBool) {
        this.yesNoBool = yesNoBool;
        return this;
    }

    public Boolean getSimpleBool() {
        return simpleBool;
    }

    public Customer setSimpleBool(Boolean simpleBool) {
        this.simpleBool = simpleBool;
        return this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", json=" + json +
                ", xml=" + xml +
                ", zoneOffset=" + zoneOffset +
                ", inetAddress=" + inetAddress +
                ", bitSetAttr=" + bitSetAttr +
                ", zonedDateTime=" + zonedDateTime +
                ", offsetDateTime=" + offsetDateTime +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", numericBoolean=" + numericBoolean +
                ", trueFalseBool=" + trueFalseBool +
                ", yesNoBool=" + yesNoBool +
                ", simpleBool=" + simpleBool +
                '}';
    }
}