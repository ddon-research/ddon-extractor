---
sidebar_position: 1
title: Architecture Documentation
description: Index page for the ddon-extractor architectural documentation.
slug: /architecture/
---

# Architecture Documentation

This folder contains the architectural documentation published to *
*[ddon-research.github.io/ddon-extractor](https://ddon-research.github.io/ddon-extractor/docs/architecture/)** via
Docusaurus.

## Documents

| # | Document                                        | Summary                                                                                                                           |
|---|-------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| 1 | [Architecture Overview](overview.md)            | Module structure, dependency graph, build system, quantitative breakdown.                                                         |
| 2 | [Core Concepts](core-concepts.md)               | Key classes and interfaces: `Resource`, `FileHeader`, `BufferReader`, deserializers, serializers, error types, custom data types. |
| 3 | [Deserialization Flow](deserialization-flow.md) | End-to-end sequence from CLI invocation to JSON output, including header identification and metadata enrichment.                  |
| 4 | [Season Handling](season-handling.md)           | How the project's layered architecture manages file format changes across DDON's three game seasons.                              |
| 5 | [Extension Mapping](extension-mapping.md)       | Comprehensive mapping of file extensions to `ClientResourceFileExtension` enum values, DTI.txt, and `FrameworkResourcesUtil`.     |
| 6 | [CLI & Packet System](cli-and-packet.md)        | Command-line interface structure (picocli), packet deserialization (experimental, Season 3 only), utility classes.                |
| 7 | [Serialization](serialization.md)               | Text serialization (JSON/YAML via Jackson), proof-of-concept binary round-trip serializers, `MetaInformation` annotation.         |
| 8 | [Crypto & Archives](crypto-and-archives.md)     | Encrypted and reference archive handling, Blowfish decryption, zlib decompression, JamCRC hashing.                                |
| 9 | [Testing](testing.md)                           | Test module structure, round-trip serialization tests, archive tests, JMH benchmarks.                                             |

## Conventions

- **Diagrams** use [Mermaid](https://mermaid.js.org/) syntax.
- **Front matter** follows the [Docusaurus docs convention](https://docusaurus.io/docs/docs-introduction).
- **Source references** point to package/class names rather than line numbers to remain stable across refactors.
