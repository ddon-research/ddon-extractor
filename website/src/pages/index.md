---
title: ddon-extractor
description: Reverse-engineering toolkit for Dragon's Dogma Online client files.
hide_table_of_contents: true
---

# ddon-extractor

A Java-based reverse-engineering toolkit for deserializing the proprietary binary client resource files of **Dragon's
Dogma Online** (DDON).

The primary goal is to convert DDON's custom binary files into human-readable **JSON** or **YAML** representations for
research and game preservation purposes.

## Quick Links

- **[Architecture Documentation](/ddon-extractor/docs/architecture/)** — Module structure, core concepts,
  deserialization flow, season handling, extension mapping, and more.
- **[Extension Mapping](/ddon-extractor/docs/architecture/extension-mapping)** — Full list of 150+ supported file
  extensions and their deserializers.
- **[GitHub Repository](https://github.com/ddon-research/ddon-extractor)** — Source code, issues, and releases.

## Key Features

- **150+ supported file extensions** with ~295 deserializers across all three game seasons
- **Blowfish-encrypted `.arc` archive** unpacking and decryption
- **JSON and YAML** output formats with optional metadata enrichment (NPC names, item names, quest names, translations)
- **Native executable** packaging via JLink/jpackage — no JRE installation required
- Experimental **network packet** deserialization (Season 3)
- Proof-of-concept **binary round-trip serialization** for select formats

## Quick Start

### Prerequisites

- [JDK 25](https://adoptium.net/releases.html) (Eclipse Adoptium)
- A DDON client installation (Season 1, 2, or 3)
- *(Optional)* A DDON translation CSV file for metadata enrichment

### Extract all ARC archives

```bash
./ddon-extractor resource -p true -o -m -f json -u -x D:\DDON_03040008 D:\DDON-translation\gmd.csv .
```

### Extract all resource files

> **Note:** This requires a prior extraction of ARC archives.

```bash
./ddon-extractor resource -p true -o -m -f json D:\DDON_03040008 D:\DDON-translation\gmd.csv .
```

### Build from source

```bash
./gradlew build
```

### Build native image

```bash
./gradlew jpackage
```

See the [Architecture Overview](/ddon-extractor/docs/architecture/overview) for the full module dependency graph and
build system details, or the [CLI & Packet System](/ddon-extractor/docs/architecture/cli-and-packet) page for the
complete command-line reference.
