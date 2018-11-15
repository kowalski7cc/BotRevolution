package com.kowalski7cc.botrevolution.types;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WebhookInfo {

    private String url;
    private Boolean hasCustomCertificate;
    private Integer pendingUpdateCount;
    private Integer lastRrrorDate;
    private String lastErrorMessage;
    private Integer maxConnections;
    private List<String> allowedUpdates;

    public WebhookInfo(String url, Integer pendingUpdateCount) {
        this.url = url;
        this.pendingUpdateCount = pendingUpdateCount;
    }

    public String getUrl() {
        return url;
    }

    public WebhookInfo setUrl(String url) {
        this.url = Objects.requireNonNull(url);
        return this;
    }

    public Integer getPendingUpdateCount() {
        return pendingUpdateCount;
    }

    public WebhookInfo setPendingUpdateCount(Integer pendingUpdateCount) {
        this.pendingUpdateCount = Objects.requireNonNull(pendingUpdateCount);
        return this;
    }

    public Optional<Boolean> getHasCustomCertificate() {
        return Optional.ofNullable(hasCustomCertificate);
    }

    public WebhookInfo setHasCustomCertificate(Boolean hasCustomCertificate) {
        this.hasCustomCertificate = hasCustomCertificate;
        return this;
    }

    public Optional<Integer> getLastRrrorDate() {
        return Optional.ofNullable(lastRrrorDate);
    }

    public WebhookInfo setLastRrrorDate(Integer lastRrrorDate) {
        this.lastRrrorDate = lastRrrorDate;
        return this;
    }

    public Optional<String> getLastErrorMessage() {
        return Optional.ofNullable(lastErrorMessage);
    }

    public WebhookInfo setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
        return this;
    }

    public Optional<Integer> getMaxConnections() {
        return Optional.ofNullable(maxConnections);
    }

    public WebhookInfo setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
        return this;
    }

    public Optional<List<String>> getAllowedUpdates() {
        return Optional.ofNullable(allowedUpdates);
    }

    public WebhookInfo setAllowedUpdates(List<String> allowedUpdates) {
        this.allowedUpdates = allowedUpdates;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebhookInfo that = (WebhookInfo) o;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return "WebhookInfo{" +
                "url='" + url + '\'' +
                ", hasCustomCertificate=" + hasCustomCertificate +
                ", pendingUpdateCount=" + pendingUpdateCount +
                ", lastRrrorDate=" + lastRrrorDate +
                ", lastErrorMessage='" + lastErrorMessage + '\'' +
                ", maxConnections=" + maxConnections +
                ", allowedUpdates=" + allowedUpdates +
                '}';
    }
}
