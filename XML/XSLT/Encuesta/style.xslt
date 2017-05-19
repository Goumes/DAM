<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	
		<html>
		
			<head>
				<title>Encuesta</title>
			</head>
			
			<body>
				<h1>Encuesta</h1>
				
				<form action = "webdeencuestas.com" method = "post">
					<fieldset>
						<xsl:for-each select = "encuesta/cuestion">
							<xsl:value-of select = "pregunta"/><br/><br/>
							<xsl:for-each select = "encuesta/cuestion">
								<input type="radio" name="radio" value="check" class="agree">
									<xsl:value-of select = "respuesta"/><br/><br/>
								</input>
							</xsl:for-each>
						</xsl:for-each>
					</fieldset>
					<input type="submit" value="Enviar"/>
				</form>
				
			</body>
		
		</html>
	
	</xsl:template>
</xsl:stylesheet>