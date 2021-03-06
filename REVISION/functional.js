const mkPower = function (n) {
    return function (x) {
        console.info(Math.pow(x, n))
    }
}
const square = mkPower(2)
const cube = mkPower(3)

cube(3)
square(3)

const compress = function (f, v) {
    const ans = f(v)
    return function (x) {
        ans(x)
    }
}

const quad = compress(mkPower, 4)
quad(6)