package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Host {
    @SerializedName("hostid")
    @Expose
    private String hostid;
    @SerializedName("proxy_hostid")
    @Expose
    private String proxyHostid;
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("disable_until")
    @Expose
    private String disableUntil;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("errors_from")
    @Expose
    private String errorsFrom;
    @SerializedName("lastaccess")
    @Expose
    private String lastaccess;
    @SerializedName("ipmi_authtype")
    @Expose
    private String ipmiAuthtype;
    @SerializedName("ipmi_privilege")
    @Expose
    private String ipmiPrivilege;
    @SerializedName("ipmi_username")
    @Expose
    private String ipmiUsername;
    @SerializedName("ipmi_password")
    @Expose
    private String ipmiPassword;
    @SerializedName("ipmi_disable_until")
    @Expose
    private String ipmiDisableUntil;
    @SerializedName("ipmi_available")
    @Expose
    private String ipmiAvailable;
    @SerializedName("snmp_disable_until")
    @Expose
    private String snmpDisableUntil;
    @SerializedName("snmp_available")
    @Expose
    private String snmpAvailable;
    @SerializedName("maintenanceid")
    @Expose
    private String maintenanceid;
    @SerializedName("maintenance_status")
    @Expose
    private String maintenanceStatus;
    @SerializedName("maintenance_type")
    @Expose
    private String maintenanceType;
    @SerializedName("maintenance_from")
    @Expose
    private String maintenanceFrom;
    @SerializedName("ipmi_errors_from")
    @Expose
    private String ipmiErrorsFrom;
    @SerializedName("snmp_errors_from")
    @Expose
    private String snmpErrorsFrom;
    @SerializedName("ipmi_error")
    @Expose
    private String ipmiError;
    @SerializedName("snmp_error")
    @Expose
    private String snmpError;
    @SerializedName("jmx_disable_until")
    @Expose
    private String jmxDisableUntil;
    @SerializedName("jmx_available")
    @Expose
    private String jmxAvailable;
    @SerializedName("jmx_errors_from")
    @Expose
    private String jmxErrorsFrom;
    @SerializedName("jmx_error")
    @Expose
    private String jmxError;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("flags")
    @Expose
    private String flags;
    @SerializedName("templateid")
    @Expose
    private String templateid;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("tls_connect")
    @Expose
    private String tlsConnect;
    @SerializedName("tls_accept")
    @Expose
    private String tlsAccept;
    @SerializedName("tls_issuer")
    @Expose
    private String tlsIssuer;
    @SerializedName("tls_subject")
    @Expose
    private String tlsSubject;
    @SerializedName("tls_psk_identity")
    @Expose
    private String tlsPskIdentity;
    @SerializedName("tls_psk")
    @Expose
    private String tlsPsk;
    @SerializedName("proxy_address")
    @Expose
    private String proxyAddress;
    @SerializedName("auto_compress")
    @Expose
    private String autoCompress;
    @SerializedName("inventory_mode")
    @Expose
    private String inventoryMode;

    public String getHostid() {
        return hostid;
    }

    public String getProxyHostid() {
        return proxyHostid;
    }

    public String getHost() {
        return host;
    }

    public String getStatus() {
        return status;
    }

    public String getDisableUntil() {
        return disableUntil;
    }

    public String getError() {
        return error;
    }

    public String getAvailable() {
        return available;
    }

    public String getErrorsFrom() {
        return errorsFrom;
    }

    public String getLastaccess() {
        return lastaccess;
    }

    public String getIpmiAuthtype() {
        return ipmiAuthtype;
    }

    public String getIpmiPrivilege() {
        return ipmiPrivilege;
    }

    public String getIpmiUsername() {
        return ipmiUsername;
    }

    public String getIpmiPassword() {
        return ipmiPassword;
    }

    public String getIpmiDisableUntil() {
        return ipmiDisableUntil;
    }

    public String getIpmiAvailable() {
        return ipmiAvailable;
    }

    public String getSnmpDisableUntil() {
        return snmpDisableUntil;
    }

    public String getSnmpAvailable() {
        return snmpAvailable;
    }

    public String getMaintenanceid() {
        return maintenanceid;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public String getMaintenanceFrom() {
        return maintenanceFrom;
    }

    public String getIpmiErrorsFrom() {
        return ipmiErrorsFrom;
    }

    public String getSnmpErrorsFrom() {
        return snmpErrorsFrom;
    }

    public String getIpmiError() {
        return ipmiError;
    }

    public String getSnmpError() {
        return snmpError;
    }

    public String getJmxDisableUntil() {
        return jmxDisableUntil;
    }

    public String getJmxAvailable() {
        return jmxAvailable;
    }

    public String getJmxErrorsFrom() {
        return jmxErrorsFrom;
    }

    public String getJmxError() {
        return jmxError;
    }

    public String getName() {
        return name;
    }

    public String getFlags() {
        return flags;
    }

    public String getTemplateid() {
        return templateid;
    }

    public String getDescription() {
        return description;
    }

    public String getTlsConnect() {
        return tlsConnect;
    }

    public String getTlsAccept() {
        return tlsAccept;
    }

    public String getTlsIssuer() {
        return tlsIssuer;
    }

    public String getTlsSubject() {
        return tlsSubject;
    }

    public String getTlsPskIdentity() {
        return tlsPskIdentity;
    }

    public String getTlsPsk() {
        return tlsPsk;
    }

    public String getProxyAddress() {
        return proxyAddress;
    }

    public String getAutoCompress() {
        return autoCompress;
    }

    public String getInventoryMode() {
        return inventoryMode;
    }
}
