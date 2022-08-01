package com.test.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.awt.*;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "jdbc_type_entity")
public class JdbcTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long bigIntAttr;

    @JdbcTypeCode(SqlTypes.BINARY)
    private String binaryAttr;

    @JdbcTypeCode(SqlTypes.BIT)
    private Boolean bitAttr;

    @JdbcTypeCode(SqlTypes.BLOB)
    private String blobAttr;

    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean boolAttr;

    @JdbcTypeCode(SqlTypes.TINYINT)
    private Byte byteAttr;

    @JdbcTypeCode(SqlTypes.CHAR)
    private String charAttr;

    @JdbcTypeCode(SqlTypes.CLOB)
    private String clobAttr;

    @JdbcTypeCode(SqlTypes.DATE)
    private Date dateAttr;

    @JdbcTypeCode(SqlTypes.DECIMAL)
    @Column(precision = 18, scale = 4)
    private String decimalAttr;

    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double doubleAttr;

    @JdbcTypeCode(SqlTypes.FLOAT)
    private Float floatAttr;

    @JdbcTypeCode(SqlTypes.GEOGRAPHY)
    private String geographyAttr;

    @JdbcTypeCode(SqlTypes.GEOMETRY)
    private String geometryAttr;

    @JdbcTypeCode(SqlTypes.INET)
    private InetAddress inetAttr;

    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer intAttr;

    @JdbcTypeCode(SqlTypes.INTERVAL_SECOND)
    private Integer intervalSecondAttr;

    @JdbcTypeCode(SqlTypes.JSON)
    private String jsonAttr;

    @JdbcTypeCode(SqlTypes.LONG32VARBINARY)
    private String long32BinaryAttr;

    @JdbcTypeCode(SqlTypes.LONG32NVARCHAR)
    private String long32NvarcharAttr;

    @JdbcTypeCode(SqlTypes.LONG32VARCHAR)
    private String long32VarcharAttr;

    @JdbcTypeCode(SqlTypes.LONGVARBINARY)
    private String longBinaryAttr;
    @JdbcTypeCode(SqlTypes.LONGNVARCHAR)
    private String longNvarcharAttr;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String longVarcharAttr;

    @JdbcTypeCode(SqlTypes.NCLOB)
    private String nCLobAttr;

    @JdbcTypeCode(SqlTypes.NCHAR)
    private String nCharAttr;
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String nVarcharAttr;
    @JdbcTypeCode(SqlTypes.NUMERIC)
    private BigDecimal numericAttr;

    @JdbcTypeCode(SqlTypes.TIMESTAMP_WITH_TIMEZONE)
    private OffsetDateTime offsetDateTimeAttr;

    @JdbcTypeCode(SqlTypes.POINT)
    private Point pointAttr;
    @JdbcTypeCode(SqlTypes.REAL)
    private Double realAttr;
    @JdbcTypeCode(SqlTypes.SMALLINT)
    private Integer smallIntAttr;
    @JdbcTypeCode(SqlTypes.TIME)
    private Time timeAttr;

    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Timestamp timestampAttr;

    @JdbcTypeCode(SqlTypes.TIMESTAMP_UTC)
    private Instant timestampUtcAttr;
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID uuidAttr;

    @JdbcTypeCode(SqlTypes.VARBINARY)
    private String varBinaryAttr;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String varcharAttr;

    @JdbcTypeCode(SqlTypes.SQLXML)
    private String xmlAttr;


    //TODO
//    @JdbcTypeCode(SqlTypes.TIME_WITH_TIMEZONE)
//    private OffsetTime offsetTimeAttr;
//    @JdbcTypeCode(SqlTypes.ARRAY)
//    private int[] arrayAttr;

//    @JdbcTypeCode(SqlTypes.JAVA_OBJECT)
//    private PojoClass javaObjectAttr;

//    @JdbcTypeCode(SqlTypes.REF_CURSOR)
//    private String refCursorAttr;

//    @JdbcTypeCode(SqlTypes.ROWID)
//    private Boolean rowIdAttr;

//    @JdbcTypeCode(SqlTypes.DATALINK)
//    private String dataLonkAttr;

//    @JdbcTypeCode(SqlTypes.REF)
//    private String refAttr;

//    @JdbcTypeCode(SqlTypes.ARRAY)
//    private int[] arrayAttr;

//    @JdbcTypeCode(SqlTypes.STRUCT)
//    private String structAttr;

//    @JdbcTypeCode(SqlTypes.DISTINCT)
//    private String distinctAttr;


//    @JdbcTypeCode(SqlTypes.OTHER)
//    private String otherAttr;

//    @JdbcTypeCode(SqlTypes.NULL)
//    private String nullAttr;
}