var arrayTasks = {

	concat: function (arr1, arr2) {
		// const newArray = [];
		// for (element of arr1) {
		// 	newArray.push(element);
		// }
		// for (element of arr2) {
		// 	newArray.push(element);
		// }
		// return newArray;
		return arr1.concat(arr2);
	},

	insertAt: function (arr, itemToAdd, index) {
		arr.splice(index, 0, itemToAdd);
		return arr;
	},

	square: function (arr) {
		// const newArray = arr.map(element => element * element);
		const newArray = arr.map(function(element){
			return element*element;
		});
		return newArray;
	},

	sum: function (arr) {
		runningTotal = 0;
		total = arr.reduce(function(runningTotal, element){
			return runningTotal + element;
		});
		return total;
	},

	findDuplicates: function (arr) {
		const newArray = [];
		for (i = 0; i < arr.length; i++) {
			let currentElement = arr[i];
			arr.splice(i, 1);
			if (arr.includes(currentElement)) {
				if (newArray.includes(currentElement) === false) {
					newArray.push(currentElement);
				}
			}
			i -= 1;
		}
		return newArray;
	},

	removeAndClone: function (arr, valueToRemove) {
		const newArray = arr;
		for (i=0; i < newArray.length; i++) {
	    if (newArray[i] === valueToRemove) {
	      newArray.splice(i, 1);
	      i -= 1;
	    }
	  }
		return newArray;
	},

	findIndexesOf: function (arr, itemToFind) {
		const newArray = [];
		for (i=0; i < arr.length; i++) {
	    if (arr[i] === itemToFind) {
				newArray.push(i);
	    }
	  }
		return newArray;
	},

	sumOfAllEvenNumbersSquared: function (arr) {
		let total = 0;
		arr.forEach(function(element){
			if(element % 2 === 0) {
				total += (element*element);
			}
		});
		return total;
	}

}

module.exports = arrayTasks
