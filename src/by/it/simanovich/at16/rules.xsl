<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/sites">
        <table border="1">
            <tr>
                <td>URL</td>
                <td>PAGES</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/sites/site">
        <tr>
            <td>
                <xsl:value-of select="@url"/>
            </td>
            <td>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>


    <xsl:template match="/sites/site/pages">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/sites/site/pages/page">
        <p>
        TITLE:<xsl:value-of select="@title"/>,
        URI:<xsl:value-of select="uri"/>
        <xsl:apply-templates select="elements"/>
        </p>
    </xsl:template>

    <xsl:template match="/sites/site/pages/page/elements">
        <br/><xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/sites/site/pages/page/elements/element">
        <xsl:value-of select="@name"/>:
        <xsl:apply-templates/><br/>
    </xsl:template>
</xsl:stylesheet>