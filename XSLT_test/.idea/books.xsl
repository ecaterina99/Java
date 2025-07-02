<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html"/>

    <xsl:template match="/">

        <html>
            <head>
                <title>books.xsl</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <td>Id</td>
                        <td>ISBN</td>
                        <td>Title</td>
                        <td>Author</td>
                    </tr>
                    <xsl:for-each select="//book">
                        <tr>
                            <td>
                                <xsl:apply-templates select="./@id"></xsl:apply-templates>
                            </td>
                            <td>
                                <xsl:apply-templates select="./@isbn"></xsl:apply-templates>
                            </td>
                            <td>
                                <xsl:apply-templates select="./title"></xsl:apply-templates>
                            </td>
                            <td>
                                <xsl:apply-templates select="./author"></xsl:apply-templates>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>