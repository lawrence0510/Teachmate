module.exports = {
  presets: [
    '@babel/preset-env',
    '@vue/cli-plugin-babel/preset'
  ],
  plugins: [
    '@babel/plugin-transform-runtime',
    'transform-vue-template',
    'transform-es2015-modules-commonjs'
  ]
}
