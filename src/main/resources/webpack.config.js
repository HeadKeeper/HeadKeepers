module.exports = {
    entry: {
        app: "./src/main.ts",
        polyfill: "./src/polyfill.ts",
        vendor: "./src/vendor.ts"
    },
    output: {
        filename: "./out/[name].js"
    },
    module: {
        loaders: [
            {
                test: /\.ts$/,
                loaders: ['ts-loader', 'angular2-template-loader?keepUrl=true'],
                exclude: /node_modules/
            },
            {
                test: /\.(html|css)$/,
                loader: 'raw',
            }
            /*{
                test: /\.html$/,
                loader: "html-loader"
            },
            {
                test: /\.css$/,
                loader: ExtractTextPlugin.extract("style-loader", "css-loader")
            }*//*,
            {
                test: /\.html$/,
                loaders: 'html-loader'
            }*/
        ]
    },
    resolve: {
        extensions: [".js", ".ts"]
    }
};