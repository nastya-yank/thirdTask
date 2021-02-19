package com.epam.golubeva.shape.entity;


import com.epam.golubeva.shape.generator.GeneratorId;

public abstract class CustomerShape {
    private long shapeId;

    public CustomerShape(){
        this.shapeId = GeneratorId.generateId();
    }

    public long getShapeId() {
        return shapeId;
    }

    public void setShapeId(long shapeId) {
        this.shapeId = shapeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        CustomerShape other = (CustomerShape) o;
        if (shapeId != other.shapeId)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (shapeId ^ (shapeId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AbstractShape [id=");
        builder.append(shapeId);
        builder.append("]");
        return builder.toString();
    }
}
