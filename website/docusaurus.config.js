// @ts-check
import {themes as prismThemes} from 'prism-react-renderer';

/** @type {import('@docusaurus/types').Config} */
const config = {
    title: 'ddon-extractor',
    tagline: 'Reverse-engineering toolkit for Dragon\'s Dogma Online client files',
    favicon: 'img/favicon.ico',

    // GitHub Pages deployment settings
    url: 'https://ddon-research.github.io',
    baseUrl: '/ddon-extractor/',
    organizationName: 'ddon-research',
    projectName: 'ddon-extractor',
    trailingSlash: false,

    onBrokenLinks: 'throw',

    i18n: {
        defaultLocale: 'en',
        locales: ['en'],
    },

    // Enable Mermaid diagram rendering
    markdown: {
        mermaid: true,
        hooks: {
            onBrokenMarkdownLinks: 'warn',
        },
    },
    themes: ['@docusaurus/theme-mermaid'],

    presets: [
        [
            'classic',
            /** @type {import('@docusaurus/preset-classic').Options} */
            ({
                docs: {
                    // Monorepo pattern: read from the repo root's docs/ folder
                    path: '../docs',
                    sidebarPath: './sidebars.js',
                    editUrl:
                        'https://github.com/ddon-research/ddon-extractor/edit/main/',
                },
                blog: false,
                theme: {
                    customCss: './src/css/custom.css',
                },
            }),
        ],
    ],

    themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
        ({
            navbar: {
                title: 'ddon-extractor',
                items: [
                    {
                        type: 'docSidebar',
                        sidebarId: 'architectureSidebar',
                        position: 'left',
                        label: 'Architecture',
                    },
                    {
                        href: 'https://github.com/ddon-research/ddon-extractor',
                        label: 'GitHub',
                        position: 'right',
                    },
                ],
            },
            footer: {
                style: 'dark',
                links: [
                    {
                        title: 'Docs',
                        items: [
                            {
                                label: 'Architecture',
                                to: '/docs/architecture/',
                            },
                        ],
                    },
                    {
                        title: 'Community',
                        items: [
                            {
                                label: 'GitHub',
                                href: 'https://github.com/ddon-research/ddon-extractor',
                            },
                        ],
                    },
                ],
                copyright: `Copyright © ${new Date().getFullYear()} ddon-research. Built with Docusaurus.`,
            },
            prism: {
                theme: prismThemes.github,
                darkTheme: prismThemes.dracula,
                additionalLanguages: ['java', 'groovy', 'bash', 'json', 'yaml'],
            },
            mermaid: {
                theme: {light: 'neutral', dark: 'dark'},
            },
        }),
};

export default config;
