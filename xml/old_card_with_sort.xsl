<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Old Cards</h2>
                <table border="1">
                    <tr bgcolor="#FF8C00">
                        <th>Theme</th>
                        <th>Type</th>
                        <th>Status</th>
                        <th>Country</th>
                        <th>Year</th>
                        <th>Author</th>
                        <th>Valuable</th>
                    </tr>
                    <xsl:for-each select="oldCards/oldCard">
                        <xsl:sort select="theme"/>
                        <tr>
                            <td><xsl:value-of select="theme"/></td>
                            <td><xsl:value-of select="cardType"/></td>
                            <td><xsl:value-of select="status"/></td>
                            <td><xsl:value-of select="country"/></td>
                            <td><xsl:value-of select="year"/></td>
                            <td><xsl:value-of select="author"/></td>
                            <td><xsl:value-of select="valuable"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

