package gr.project.dungeonFighter.core.specification;

import gr.project.dungeonFighter.model.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> searchByUsernameOrEmail(String search) {
        return ((root, query, cb) -> {
            if (search == null || search.trim().isEmpty()) return null;
            String pattern = "%" + search.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("username")), pattern),
                    cb.like(cb.lower(root.get("email")), pattern)
            );
        });
    }

    public static Specification<User> isActive(Boolean isActive) {
        return ((root, query, cb) -> {
           if (isActive == null) return null;
           return cb.equal(root.get("isActive"), isActive);
        });
    }
}
