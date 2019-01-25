$(function(){
    var stateOptions;
    var districtOptions;
    $.getJSON('indianStates.1.json',function(result){
        $.each(result, function(stateCode,stateName) {
            //<option value='stateCode'>stateName</option>
            stateOptions+="<option value='"
            +stateCode+
            "'>"
            +stateName+
            "</option>";
             });
             $('#state').html(stateOptions);
        });

        $("#state").change(function(){
            
                    $.getJSON('MHDistricts.json',function(result){
                    $.each(result, function(i,district) {
                        //<option value='districtName'>districtName</option>
                        districtOptions+="<option value='"
                        +district.name+
                        "'>"
                        +district.name+
                        "</option>";
                         });
                         $('#district').html(districtOptions);
                    });
                
            });
    
});
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