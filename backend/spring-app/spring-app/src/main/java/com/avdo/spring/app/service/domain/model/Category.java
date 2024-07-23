package com.avdo.spring.app.service.domain.model;

public class Category {

    private final Long id;
    private final String name;

    Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static class CategoryBuilder {
        private Long id;
        private String name;

        CategoryBuilder() {
        }

        public CategoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Category build() {
            return new Category(this.id, this.name);
        }
    }

    public String toString() {
        return "Category(id=" + this.getId() +
                ", name=" + this.getName() + ")";
    }
}
