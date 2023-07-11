const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path');

module.exports = {
    entry: './src/main/index.js',
    output: {
        path: path.join(__dirname, 'dist'),
        filename: 'bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-react'],
                    },
                },
            },
            {
                test:  /\.html$/,
                use: { loader: "html-loader" }
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader'],
            }
        ],
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: './public/index.html',
            filename: 'index.html'
        }),
    ],
    devServer: {
        port: 3000,
        proxy:{
           '/task-manager':{
               target : 'http://localhost:8000/',
               pathRewrite: { '^/task-manager': '' },
           }
        },
        static: {
            directory: path.resolve(__dirname, './public'),
        },
    },
};
