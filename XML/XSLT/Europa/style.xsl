<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Viva Armenia</title>
			</head>
			
			<body>
			
				<h2>Armenia mola</h2>
				
				<table border = "1">
					<tr bgcolor = "orange">
						<th>Nombre</th>
						<th>Habitantes</th>
						<th>Capital</th>
						<th>Sigla-Pais</th>
						<th>Prefijo</th>
					</tr>
					
					<xsl:for-each select ="Europa/pais">
						<tr>
							<td>
								<xsl:value-of select = "nombre"/>
							</td>
							
							<td>
								<xsl:value-of select = "habitantes"/>
							</td>
							
							<td>
								<xsl:value-of select = "capital"/>
							</td>
							
							<td>
								<xsl:value-of select = "sigla-pais"/>
							</td>
							
							<td>
								<xsl:value-of select = "prefijo"/>
							</td>
						</tr>
					</xsl:for-each>
				</table>
				
				<p>Armenia ha vencido a xslt</p>
				
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>