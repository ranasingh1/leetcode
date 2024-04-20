/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    
    return new Promise (async( res , rej)=>{
         const sum = await Promise.all([promise1, promise2]);
         let ans = sum.reduce((acc, currValue)=>{
            return acc+ currValue
         }, 0);
         res(ans);
    })

};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */