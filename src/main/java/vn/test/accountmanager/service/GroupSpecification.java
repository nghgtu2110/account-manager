package vn.test.accountmanager.service;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import vn.test.accountmanager.entity.Group;
import vn.test.accountmanager.model.GroupFilterForm;

import java.util.ArrayList;
import java.util.List;

public class GroupSpecification {

    public static Specification<Group> buildWhere(GroupFilterForm form) {
        return (root, query, criteriaBuilder) -> {
            if (form == null) {
                return null;
            }

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(form.getName())) {
                String keyword = "%" + form.getName().trim().toLowerCase() + "%";
                Predicate pred = criteriaBuilder.like(criteriaBuilder.lower(root.get("groupName")), keyword);
                predicates.add(pred);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
