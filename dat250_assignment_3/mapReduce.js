db.idk.insertMany( [
    { _id: 0, type: "pepperoni", size: "small", price: 4 },
    { _id: 1, type: "cheese", size: "medium", price: 7 },
    { _id: 2, type: "vegan", size: "large", price: 8 },
    { _id: 3, type: "murshoom", size: "small", price: 33 },
    { _id: 4, type: "salt", size: "medium", price: 99 },
    { _id: 5, type: "hotdog", size: "large", price: 77 }
 ] )


db.idk.mapReduce(
    function() {emit(this.size, this.price);},
    function(size, prices) {return Array.sum(prices)},
    {
        query: {size:"small"},
        out: "small_total"
    }
)