<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	
	<html>
	
		<head>
		
		<title>El Universo</title>
		
		</head>
		
		<body>
		
			<h2>El Universo es infinito, al igual que Armenia</h2>
			<table border = "1">
				<tr bgcolor="red">
					<th>Estrella</th>
					<th>Planeta</th>
					<th>Satelites</th>
					<th>Asteroides</th>
				</tr>
				
				<xsl:for-each select = "Universo/galaxia">
				<xsl:if test="estrella=&quot;Sol&quot;">   <!--(hay dos formas de hacerlo) 
															xsl:if contains(estrella,'Sol') -->
				
					<tr bgcolor="orange">
					
						<td>
							<xsl:value-of select = "estrella"/>
						</td>
						
						<td>
							<xsl:value-of select = "planeta"/>
						</td>
						
						<td>
							<xsl:value-of select = "satelites"/>
						</td>
						
						<td>
							<xsl:value-of select = "asteroides"/>
						</td>
					
					</tr>
				</xsl:if>
				</xsl:for-each>
				
			</table>
			
			<p>El universo es incierto, pero más incierto es qué voy almorzar hoy</p>
		
		</body>
	
	</html>
	
	</xsl:template>
	
</xsl:stylesheet>