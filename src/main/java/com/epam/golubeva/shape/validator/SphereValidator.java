package com.epam.golubeva.shape.validator;

import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.entity.Sphere;

public class SphereValidator {
    public static boolean isSphere(Sphere sphere) {
        CustomerPoint center = sphere.getCenter();
        CustomerPoint boundary = sphere.getBoundary();
        double radius = sphere.getRadius();
        double x1 = center.getX();
        double y1 = center.getY();
        double z1 = center.getZ();
        double x2 = boundary.getX();
        double y2 = boundary.getY();
        double z2 = boundary.getZ();
        boolean result = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2) == Math.pow(radius, 2);
        return result;
    }
    public static boolean isTouchUpon(Sphere sphere) {
        CustomerPoint center = sphere.getCenter();
        double radius = sphere.getRadius();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        if (x + radius == 0 || x - radius == 0 ||
                y + radius == 0 || y - radius == 0 ||
                z + radius == 0	|| z - radius == 0) {
            return true;
        }
        return false;
    }
}
