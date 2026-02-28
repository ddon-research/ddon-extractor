/** @type {import('@docusaurus/plugin-content-docs').SidebarsConfig} */
const sidebars = {
    architectureSidebar: [
        {
            type: 'category',
            label: 'Architecture',
            link: {
                type: 'doc',
                id: 'architecture/README',
            },
            items: [
                'architecture/overview',
                'architecture/core-concepts',
                'architecture/deserialization-flow',
                'architecture/season-handling',
                'architecture/extension-mapping',
                'architecture/cli-and-packet',
                'architecture/serialization',
                'architecture/crypto-and-archives',
                'architecture/testing',
            ],
        },
    ],
};

export default sidebars;
