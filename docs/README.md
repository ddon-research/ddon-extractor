---
sidebar_position: 1
title: Documentation
description: Documentation home for the ddon-extractor project.
slug: /
---

# Documentation

This folder contains the source for
the [ddon-extractor documentation site](https://ddon-research.github.io/ddon-extractor/).

The site is built with [Docusaurus 3](https://docusaurus.io/) and deployed automatically to GitHub Pages when changes
are pushed to `main`. See the [`website/`](https://github.com/ddon-research/ddon-extractor/tree/main/website) folder for
the Docusaurus configuration.

## Contents

- **[Architecture](architecture/README.md)** — Comprehensive architectural documentation covering module structure, core
  concepts, deserialization flow, season handling, extension mapping, CLI & packet system, serialization, crypto &
  archives, and testing.
- **[Supported File Extensions](deserialization/supported-file-extensions.csv)** — Legacy CSV listing of a subset of
  supported file extensions. See the [Extension Mapping](architecture/extension-mapping.md) page for the complete list.
