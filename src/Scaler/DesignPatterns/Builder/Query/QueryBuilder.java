package Scaler.DesignPatterns.Builder.Query;

@WithBuilder
public class QueryBuilder {
    private final String select;
    private final String from;
    private final String where;
    private final String join;
    private final String orderBy;
    private final String groupBy;

    private QueryBuilder(Builder builder) {
        this.select = builder.select;
        this.from = builder.from;
        this.where = builder.where;
        this.join = builder.join;
        this.orderBy = builder.orderBy;
        this.groupBy = builder.groupBy;
    }

    public String getSelect() {
        return select;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    public String getJoin() {
        return join;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder {
        private String select;
        private String from;
        private String where;
        private String join;
        private String orderBy;
        private String groupBy;

        public Builder setSelect(String select) {
            this.select = select;
            return this;
        }

        public Builder setFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder setGroupBy(String groupBy) {
            this.groupBy = groupBy;
            return this;
        }

        public Builder setJoin(String join) {
            this.join = join;
            return this;
        }

        public Builder setOrderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public Builder setWhere(String where) {
            this.where = where;
            return this;
        }

        public QueryBuilder build() {
            return new QueryBuilder(this);
        }
    }
}