loadAllHotels();

function loadAllHotels() {

    function loadHotelData() {
        $.ajax({
            url: 'http://localhost:8070/Mapping/api/hotel', // Replace with your actual backend URL
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.code === '200') {
                    var hotels = data.data;
                    var hotelList = $('#card-container');

                    // Iterate through the hotel data and create card elements
                    for (var i = 0; i < hotels.length; i++) {
                        var hotel = hotels[i];
                        var card = `
                                      <div class="col-12 col-md-6 col-lg-3 card-wrapper mt-4">
                                        <div class="card">
                                          <img class="card-img-top" src="images/1.jpg" alt="...">
                                          <div class="card-body">
                                            <!--  Customize this section  -->
                                             <div class="card-title" title=""><u><h5>`+hotel.hotel_name+`</h5></u></div>
                                              <div class="card-title" title="">`+hotel.hotel_category+`</div>
                                              <div class="card-title" title="">`+hotel.location+`</div>
                                              <div class="card-title" title="">`+hotel.emial+`</div>
                                              <div class="card-title" title="">`+hotel.contact_01+`</div>
                                              <div class="card-title" title="">`+hotel.contact_02+`</div>
                                              <div class="card-title" title="">`+hotel.pets_allow_or_not+`</div>
                                            
                                         
                                            <!--  End  -->
                                          </div>
                                        </div>
                                      </div>
                        `;



                        vehiclelList.append(card);

                    }
                } else {
                    // Handle the error case here
                    console.log('Error: ' + data.message);
                }
            },
            error: function (error) {
                // Handle the error case here
                console.log('Error: ' + error);
            }
        });
    }

    // Call the function to load hotel data
    loadHotelData();



}

