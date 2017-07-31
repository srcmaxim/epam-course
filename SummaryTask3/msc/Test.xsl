<?xml version="1.0" encoding="UTF-8"?>
<!-- XSL transformation -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:st3="http://knure.kharkov.ua/jt/st3example" version="1.0">

    <xsl:template match="/st3:Test">
        <html>
            <head>
                <title>Test</title>
                <style type="text/css">
                    td {border: 1px solid black; padding: 5px;}
                    table {border: 2px solid black;}
                </style>
            </head>
            <body>
                <table>
                    <xsl:apply-templates select="Question"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Question">
        <tr>
            <td colspan="2">
                <xsl:value-of select="QuestionText"/>
            </td>
        </tr>
        <xsl:apply-templates select="Answer"/>
    </xsl:template>

    <xsl:template match="Answer">
        <tr>
            <td>
                <xsl:value-of select="current()"/>
            </td>
            <td>
                <xsl:if test="@correct = 'true'">
                    CORRECT
                </xsl:if>
            </td>
        </tr>
    </xsl:template>

</xsl:stylesheet>