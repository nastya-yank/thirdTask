package com.epam.golubeva.shape.comparator;

import com.epam.golubeva.shape.action.SphereAction;
import com.epam.golubeva.shape.entity.CustomerShape;
import com.epam.golubeva.shape.entity.Sphere;

import java.util.Comparator;

public enum SphereComparator implements Comparator<CustomerShape> {
    ID {
        @Override
        public int compare(CustomerShape sh1, CustomerShape sh2) {
            return Long.compare(sh1.getShapeId(), sh2.getShapeId());
        }
    },
    RADIUS {
        @Override
        public int compare(CustomerShape sh1, CustomerShape sh2) {
            Sphere sphere1 = (Sphere) sh1;
            Sphere sphere2 = (Sphere) sh2;
            return Double.compare(SphereAction.getRadius(sphere1), SphereAction.getRadius(sphere2));
        }
    },
    CENTER_X {
        @Override
        public int compare(CustomerShape sh1, CustomerShape sh2) {
            Sphere sphere1 = (Sphere) sh1;
            Sphere sphere2 = (Sphere) sh2;
            return Double.compare(sphere1.getCenter().getX(), sphere2.getCenter().getX());
        }
    },
    CENTER_Y {
        @Override
        public int compare(CustomerShape sh1, CustomerShape sh2) {
            Sphere sphere1 = (Sphere) sh1;
            Sphere sphere2 = (Sphere) sh2;
            return Double.compare(sphere1.getCenter().getY(), sphere2.getCenter().getY());
        }
    },
    CENTER_Z {
        @Override
        public int compare(CustomerShape sh1, CustomerShape sh2) {
            Sphere sphere1 = (Sphere) sh1;
            Sphere sphere2 = (Sphere) sh2;
            return Double.compare(sphere1.getCenter().getZ(), sphere2.getCenter().getZ());
        }
    }
}
