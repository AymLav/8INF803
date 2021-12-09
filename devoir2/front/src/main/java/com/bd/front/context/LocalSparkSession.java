package com.bd.front.context;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class LocalSparkSession
{
    private final SparkSession sparkSession;

    private LocalSparkSession()
    {
        sparkSession = SparkSession
                .builder()
                .appName("Search")
                .master("local[2]")
                .getOrCreate();
    }

    public SparkSession getSparkSession()
    {
        return sparkSession;
    }

    public static LocalSparkSession getInstance()
    {
        return LocalSparkSessionHolder.INSTANCE;
    }

    private static class LocalSparkSessionHolder
    {
        private static final LocalSparkSession INSTANCE = new LocalSparkSession();
    }
}