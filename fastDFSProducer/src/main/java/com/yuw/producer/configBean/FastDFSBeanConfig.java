package com.yuw.producer.configBean;

import org.csource.fastdfs.ClientGlobal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.yw.FastDFSBean;
import org.yw.FastDFSClient;
import org.yw.interfaces.FastDFSDefault;
import org.yw.interfaces.FastDFSDefaultImp;

import java.util.Properties;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/10/12 10:04
 */
@Component
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "fastdfs")
public class FastDFSBeanConfig {

    @Value("${es_file_server_addr}")
    private String fileServerAdder;

    @Value("${es_max_storage_connection}")
    private String maxStorageConnection;

    @Value("${es_flag_file_name}")
    private String flagFileName;

    @Value("${es_flag_file_suffix}")
    private String flagFileSuffix;

    @Value("${es_max_file_size}")
    private String maxFileSize;

    @Value("${es_minIdle}")
    private String minIdle;

    /**
     * fastDFS Properties
     */
    private String charset;
    private String httpAntiStealToken;
    private String httpSecretKey;
    private String httpTrackerHttpPort;
    private String trackerServers;
    private String connectTimeoutInSeconds;
    private String networkTimeoutInSeconds;

    @Bean
    public FastDFSBean fastDFSBean(){
        FastDFSBean fastDFSBean = new FastDFSBean();
        fastDFSBean.setMaxFileSize(Long.valueOf(maxFileSize));
        fastDFSBean.setMaxStorageConnection(Integer.valueOf(maxStorageConnection));
        fastDFSBean.setFlagFileName(flagFileName);
        fastDFSBean.setMinIdle(Integer.valueOf(minIdle));
        fastDFSBean.setHttpSecretKey(httpSecretKey);
        fastDFSBean.setFlagFileSuffix(flagFileSuffix);
        fastDFSBean.setFileServerAdder(fileServerAdder);

        Properties properties = new Properties();
        properties.setProperty(ClientGlobal.PROP_KEY_CHARSET,getCharset());
        properties.setProperty(ClientGlobal.PROP_KEY_HTTP_SECRET_KEY,getHttpSecretKey());
        properties.setProperty(ClientGlobal.PROP_KEY_CONNECT_TIMEOUT_IN_SECONDS,getConnectTimeoutInSeconds());
        properties.setProperty(ClientGlobal.PROP_KEY_HTTP_ANTI_STEAL_TOKEN,getHttpAntiStealToken());
        properties.setProperty(ClientGlobal.PROP_KEY_HTTP_TRACKER_HTTP_PORT,getHttpTrackerHttpPort());
        properties.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS,getTrackerServers());
        fastDFSBean.setProperties(properties);
        return fastDFSBean;
    }

    @Bean
    public FastDFSClient fastDFSClient(FastDFSBean fastDFSBean){
        return new FastDFSClient(fastDFSBean);
    }

    @Bean
    public FastDFSDefault fastDFSDefault(FastDFSClient fastDFSClient){
        return new FastDFSDefaultImp(fastDFSClient);
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getHttpAntiStealToken() {
        return httpAntiStealToken;
    }

    public void setHttpAntiStealToken(String httpAntiStealToken) {
        this.httpAntiStealToken = httpAntiStealToken;
    }

    public String getHttpSecretKey() {
        return httpSecretKey;
    }

    public void setHttpSecretKey(String httpSecretKey) {
        this.httpSecretKey = httpSecretKey;
    }

    public String getHttpTrackerHttpPort() {
        return httpTrackerHttpPort;
    }

    public void setHttpTrackerHttpPort(String httpTrackerHttpPort) {
        this.httpTrackerHttpPort = httpTrackerHttpPort;
    }

    public String getTrackerServers() {
        return trackerServers;
    }

    public void setTrackerServers(String trackerServers) {
        this.trackerServers = trackerServers;
    }

    public String getConnectTimeoutInSeconds() {
        return connectTimeoutInSeconds;
    }

    public void setConnectTimeoutInSeconds(String connectTimeoutInSeconds) {
        this.connectTimeoutInSeconds = connectTimeoutInSeconds;
    }

    public String getNetworkTimeoutInSeconds() {
        return networkTimeoutInSeconds;
    }

    public void setNetworkTimeoutInSeconds(String networkTimeoutInSeconds) {
        this.networkTimeoutInSeconds = networkTimeoutInSeconds;
    }
}
