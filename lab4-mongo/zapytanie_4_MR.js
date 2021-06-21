// use('nbd')
var mapFunction = function(){
var bmi = this.weight/(this.height*this.height)
    emit(this.nationality, {
      bmiSum:bmi,
      minBmi:bmi,
      maxBmi:bmi,
      count:1
    });

};
//mapping and reducing should have the same structure
//{sum, min, max, count}
var reduceFunction = function(job, bmi){
  var minimal = bmi[0].minBmi;
  var maximal = bmi[0].maxBmi;
  var summed = 0;
  var counter = 0;
  bmi.forEach(e => {
    counter += e.count;
    summed += e.bmiSum;
    if(e.minBmi<minimal) minimal = e.minBmi;
    if(e.maxBmi>maximal) maximal = e.maxBmi;
  });
    var reducedValue = {
      bmiSum:summed,
      BMImin:minimal,
      BMImax:maximal,
      count:counter
    };
    return reducedValue;
};
//finalize function which counts average
var finalizeFunction = function(nationality, reducedValues) {
  return {
    minBMI: reducedValues.BMImin,
    maxBMI: reducedValues.BMImax,
    averageBMI: reducedValues.bmiSum/reducedValues.count
  };
}
db.people.mapReduce(
  mapFunction,
  reduceFunction,
  {
    out: "map_reduce_4"
    ,
    finalize: finalizeFunction
  }
)

printjson(db.map_reduce_4.find().sort( { _id: 1 } ).toArray())