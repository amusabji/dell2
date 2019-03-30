// format phone number fields
$('.js-format-phone').mask('(000)-000-0000')

// filter tables using the topbar search input 
$(".js-input-table-search").on("keyup", function () {
  var value = $(this).val().toLowerCase();
  $("table tr").filter(function () {
    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
  })
})


$('[data-toggle=confirmation]').confirmation({
  rootSelector: '[data-toggle=confirmation]',
  container: 'body'
});
$('[data-toggle=confirmation-singleton]').confirmation({
  rootSelector: '[data-toggle=confirmation-singleton]',
  container: 'body'
});
$('[data-toggle=confirmation-popout]').confirmation({
  rootSelector: '[data-toggle=confirmation-popout]',
  container: 'body'
});

$('#confirmation-delegate').confirmation({
  selector: 'button'
});

$('[data-toggle=custom-confirmation-events]')
  .confirmation({
    rootSelector: '[data-toggle=custom-confirmation-events]',
    container: 'body'
  })
  .on('mouseenter', function () {
    $(this).confirmation('show');
  })
  .on('myevent', function () {
    alert('"myevent" triggered');
  });

$('#custom-confirmation').confirmation({
  rootSelector: '#custom-confirmation',
  container: 'body',
  title: '',
  onConfirm: function (value) {
    alert('You choosed ' + value);
  },
  buttons: [{
      class: 'btn btn-sm btn-danger',
      iconClass: 'material-icons mr-1',
      iconContent: 'directions_railway',
      label: 'Railway',
      value: 'Railway'
    },
    {
      class: 'btn btn-sm btn-primary',
      iconClass: 'material-icons mr-1',
      iconContent: 'directions_car',
      label: 'Car',
      value: 'Car'
    },
    {
      class: 'btn btn-sm btn-warning',
      iconClass: 'material-icons mr-1',
      iconContent: 'directions_boat',
      label: 'Boat',
      value: 'Boat'
    },
    {
      class: 'btn btn-sm btn-secondary',
      iconClass: 'material-icons mr-1',
      iconContent: 'cancel',
      label: 'Cancel',
      cancel: true
    }
  ]
});

$('#custom-confirmation-links').confirmation({
  rootSelector: '#custom-confirmation-link',
  container: 'body',
  title: '',
  buttons: [{
      label: 'Twitter',
      iconClass: 'fa fa-twitter fa-lg mr-1',
      attr: {
        href: 'https://twitter.com',
        target: '_blank'
      }
    },
    {
      label: 'Facebook',
      iconClass: 'fa fa-facebook fa-lg mr-1',
      attr: {
        href: 'https://facebook.com',
        target: '_blank'
      }
    },
    {
      label: 'Pinterest',
      iconClass: 'fa fa-pinterest fa-lg mr-1',
      attr: {
        href: 'https://pinterest.com',
        target: '_blank'
      }
    }
  ]
});