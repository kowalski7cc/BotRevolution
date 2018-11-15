package com.kowalski7cc.botrevolution.types.stickers;

import com.kowalski7cc.botrevolution.types.JSONSerializable;
import org.json.JSONObject;

import java.util.Objects;

public class MaskPosition implements JSONSerializable {

    private MaskPositionPoint point;
    private Float xShift;
    private Float yShift;
    private Float scale;

    @Override
    public JSONObject serializeJSON() {
        return new JSONObject().put("point", point.toString())
                .put("x_shift", xShift)
                .put("y_shift", yShift)
                .put("scale", scale);
    }

    public enum MaskPositionPoint {
        FOREHEAD,
        EYES,
        MOUTH,
        CHIN
    }

    public MaskPosition(MaskPositionPoint point, Float xShift, Float yShift, Float scale) {
        this.point = Objects.requireNonNull(point);
        this.xShift = Objects.requireNonNull(xShift);
        this.yShift = Objects.requireNonNull(yShift);
        this.scale = Objects.requireNonNull(scale);
    }

    public MaskPositionPoint getPoint() {
        return point;
    }

    public MaskPosition setPoint(MaskPositionPoint point) {
        this.point = Objects.requireNonNull(point);
        return this;
    }

    public Float getxShift() {
        return xShift;
    }

    public MaskPosition setxShift(Float xShift) {
        this.xShift = Objects.requireNonNull(xShift);
        return this;
    }

    public Float getyShift() {
        return yShift;
    }

    public MaskPosition setyShift(Float yShift) {
        this.yShift = Objects.requireNonNull(yShift);
        return this;
    }

    public Float getScale() {
        return scale;
    }

    public MaskPosition setScale(Float scale) {
        this.scale = Objects.requireNonNull(scale);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaskPosition)) return false;
        MaskPosition that = (MaskPosition) o;
        return point == that.point &&
                xShift.equals(that.xShift) &&
                yShift.equals(that.yShift) &&
                scale.equals(that.scale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, xShift, yShift, scale);
    }

    @Override
    public String toString() {
        return "MaskPosition{" +
                "point=" + point +
                ", xShift=" + xShift +
                ", yShift=" + yShift +
                ", scale=" + scale +
                '}';
    }
}
