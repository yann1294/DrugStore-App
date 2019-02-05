function isNumberKey(evt)
{
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode != 46 && charCode > 31 
    && (charCode < 48 || charCode > 57))
    return false;
    return true;
}  


function isNumericKey(evt)
{
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode != 46 && charCode > 31 
    && (charCode < 48 || charCode > 57))
    return true;
    return false;
}
$(function () {

    /**
     * Breaks down given fieldName string to pieces. For ex:
     *
     * If fieldName is "contact[person][name]" result is ["person", "name"].
     * If keepFirstElement is true then result is ["contact", "person", "name"].
     * Result may vary if you pass different expression.
     *
     * @param {string} fieldName that will be splited by expression param.
     * @param {regexp} expression used to break down fieldName to pieces.
     * @param {boolean} keepFirstElement if false/null first extracted name part will be ommited.
     * @return {array} array of strings.
     */
    var extractFieldNames = function (fieldName, expression, keepFirstElement) {

        expression = expression || /([^\]\[]+)/g;
        keepFirstElement = keepFirstElement || false;

        var elements = [];

        while ((searchResult = expression.exec(fieldName))) {
            elements.push(searchResult[0]);
        }

        if (!keepFirstElement && elements.length > 0) elements.shift();

        return elements;
    }

    /**
      * This function modifies target object by setting chain of nested fields.
      * Fields will have names as passed in properties array. Value param is assigned to 
      * field at the end of chain. For ex:
      *
      * If properties array is ["person", "name"] and value is "abc", target object will be 
      * modified in this way: target.person.name = "abc";
      *
      * If field at the end is already defined in target, function won't overwrite it.
      *
      * @param {object} object that this function will modify.
      * @param {array} properties to be createad in target object.
      * @param {*} value that will be assigned to the field at the end of chain.
      */
    var attachProperties = function (target, properties, value) {

        var currentTarget = target;
        var propertiesNum = properties.length;
        var lastIndex = propertiesNum - 1;

        for (var i = 0; i < propertiesNum; ++i) {
            currentProperty = properties[i];

            if (currentTarget[currentProperty] === undefined) {
                currentTarget[currentProperty] = (i === lastIndex) ? value : {};
            }

            currentTarget = currentTarget[currentProperty];
        }
    }

    /**
      * This function converts form fields and values to object stucture that
      * then can be easely stringyfied with JSON.stringify() method.
      * 
      * Form fields shoud be named in [square][brackets] convention.
      * Nesting of fields will be keeped. 
      *
      * @param {object} jQuery object that represents form element.
      * @return {object} plain JS object with properties named after form fields.
      */
    var convertFormDataToObject = function (form) {

        var currentField = null;
        var currentProperties = null;

        // result of this function
        var data = {};

        // get array of fields that exist in this form
        var fields = form.serializeArray();
        console.log(fields);
        for (var i = 0; i < fields.length; ++i) {
            currentField = fields[i];
            // extract field names
            currentProperties = extractFieldNames(currentField.name);
            // add new fields to our data object
            attachProperties(data, currentProperties, currentField.value);
        }

        return data;
    }


    // lets do this...
    var form = $('#registration-form');
    var data = convertFormDataToObject(form);

    console.log(data);

    // send data with ajax...

}); 