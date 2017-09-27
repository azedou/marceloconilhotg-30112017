var packageJSON = require('./package.json');
var path = require('path');
var webpack = require('webpack');

const PATHS = {
  build: path.join(__dirname, 'target', 'classes', 'META-INF', 'resources', 'webjars', packageJSON.name, packageJSON.version)
};



module.exports = {
    entry: [
        './src/index.js'
    ],
  output: {
    path: PATHS.build,
    publicPath: '/assets/',
    filename: 'app-bundle.js'
  },
    module: {
        loaders: [{
            exclude: /node_modules/,
            loader: 'babel',
            query: {
                presets: ['react', 'es2015', 'stage-1']
            }
        },{
            test: /\.scss$/,
            use: [
                {
                    loader: "style-loader"
                },
                {
                    loader: "css-loader",
                    options: {
                        alias: {
                            "../fonts/bootstrap": "bootstrap-sass/assets/fonts/bootstrap"
                        }
                    }
                },
                {
                    loader: "sass-loader",
                    options: {
                        includePaths: [
                            path.resolve("./node_modules/bootstrap-sass/assets/stylesheets")
                            ]
                    }
                }
                ]
        },{
            test: /\.css$/,
            loader: "style-loader!css-loader"
        }
        ]
    },
    resolve: {
        extensions: ['', '.js', '.jsx']
    },
    plugins: [
        new webpack.DefinePlugin({
            'process.env': {
                'NODE_ENV': JSON.stringify(process.env.NODE_ENV)
            }
        })
    ]
};
