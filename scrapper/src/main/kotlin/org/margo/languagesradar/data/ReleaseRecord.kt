package org.margo.languagesradar.data

import org.margo.languagesradar.Language

data class ReleaseRecord (
    val language: Language,
    val supportedVersion: String,
    val latestVersion: String,
    val latestReleaseNote: String
)