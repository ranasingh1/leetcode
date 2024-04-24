/**
 * @param {string} s
 * @param {number} minJump
 * @param {number} maxJump
 * @return {boolean}
 */
var canReach = function (s, minJmp, maxJmp) {
  const n = s.length
  const canReach = new Array(n).fill(0)
  canReach[0] = 1
  for (let i = 0; i < n; i++) {
    if (canReach[i]) {
      for (let j = i + minJmp; j <= i + maxJmp; j++) {
        if (s[j] === "0") {
          canReach[j] = 1
        }
      }
      for (i++; canReach[i]; i++) {
        const j = i + maxJmp
        if (s[j] === "0") {
          canReach[j] = 1
        }
      }
    }
  }
  return canReach[n - 1]
}