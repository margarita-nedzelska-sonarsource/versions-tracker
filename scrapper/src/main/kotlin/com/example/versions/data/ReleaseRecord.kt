package com.example.versions.data

import com.example.versions.Project

data class ReleaseRecord (
    val project: Project,
    val supportedVersion: String,
    val latestVersion: String,
    val latestReleaseNote: String
)