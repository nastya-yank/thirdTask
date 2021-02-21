package com.epam.golubeva.shape.validator;

import com.epam.golubeva.shape.action.SphereAction;
import com.epam.golubeva.shape.entity.CustomerPoint;
import com.epam.golubeva.shape.entity.Sphere;

public class SphereValidator {
    public static boolean isSphere(Sphere sphere) {
        return SphereAction.getRadius(sphere) > 0;
    }

    public static boolean isTouchUpon(Sphere sphere) {
        CustomerPoint center = sphere.getCenter();
        double radius = SphereAction.getRadius(sphere);
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        if (x + radius == 0 || x - radius == 0 ||
                y + radius == 0 || y - radius == 0 ||
                z + radius == 0 || z - radius == 0) {
            return true;
        }
        return false;
    }
}
