<?xml version="1.0"?>
<!-- 
*******************************************************************************
 * Copyright (c) 2008 Standards for Technology in Automotive Retail and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Carver - STAR - Extended existing eclipse.xsl file to produce valid
 *                           eclipse 3.3 plugin.xml with a manifest file.
 *******************************************************************************/
 
 -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:ng="http://docbook.org/docbook-ng" xmlns:db="http://docbook.org/ns/docbook"
    xmlns:exsl="http://exslt.org/common" version="1.0"
    exclude-result-prefixes="exsl db ng">
    <xsl:import href="eclipse.xsl"/>
    <xsl:param name="manifest">1</xsl:param>
    <xsl:param name="create.plugin.xml">1</xsl:param>

    <xsl:template name="plugin.xml">
        <xsl:if test="$create.plugin.xml = '1'">
            <xsl:call-template name="write.chunk">
                <xsl:with-param name="filename">
                    <xsl:if test="$manifest.in.base.dir != 0">
                        <xsl:value-of select="$base.dir" />
                    </xsl:if>
                    <xsl:value-of select="'plugin.xml'" />
                </xsl:with-param>
                <xsl:with-param name="method" select="'xml'" />
                <xsl:with-param name="encoding" select="'utf-8'" />
                <xsl:with-param name="indent" select="'yes'" />
                <xsl:with-param name="content">
                    <xsl:choose>
                        <xsl:when test="$manifest = '1'">
                           <plugin>
                                <extension point="org.eclipse.help.toc">
                                    <toc file="toc.xml" primary="true" />
                                </extension>
                           </plugin>
                        </xsl:when>
                        <xsl:otherwise>
                            <plugin name="{$eclipse.plugin.name}" id="{$eclipse.plugin.id}"
                                version="1.0" provider-name="{$eclipse.plugin.provider}">
                                <extension point="org.eclipse.help.toc">
                                    <toc file="toc.xml" primary="true" />
                                </extension>
                            </plugin>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:with-param>
            </xsl:call-template>        
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>