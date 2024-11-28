module medicine {
	requires java.sql;
	opens Medicine to test;
	opens test to java.sql; 
	exports test;
}