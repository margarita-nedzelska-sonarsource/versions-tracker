package com.example.versions.data

import com.example.versions.Language

data class ReleaseRecord (
        val language: Language,
        val supportedVersion: String,
        val latestVersion: String,
        val latestReleaseNote: String
)