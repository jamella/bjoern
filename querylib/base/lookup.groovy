Object.metaClass.queryNodeIndex = { luceneQuery ->
	queryStr = 'SELECT * FROM V WHERE [childNum,code,comment,nodeType,repr] LUCENE "' + luceneQuery + '"';
	query = new com.orientechnologies.orient.core.sql.OCommandSQL(queryStr);
	g.getRawGraph().command(query).execute().toList()._().transform{ g.v(it.getIdentity()) }
}
