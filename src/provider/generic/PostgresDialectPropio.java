package provider.generic;

public class PostgresDialectPropio extends org.hibernate.dialect.PostgreSQL94Dialect {

    @Override
    public String getCurrentSchemaCommand() {
        return super.getCurrentSchemaCommand();
    }
}
