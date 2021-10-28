//Using this JavaScript, the page will be reloaded at a given time (10 minutes for default).

var idleTime = 0;

$(document).ready(function () {

  //Increment the idle time counter every second (1000 milisecond).
  setInterval(timerIncrement, 1000);
});

function barChartOneDecimalTooltipContentEditor(str, seriesIndex, pointIndex, plot) {

  var result = "" + plot.data[seriesIndex][pointIndex];
  if (result.indexOf(".") === -1) {
    return result + ".0";
  }
  return addCommas(result);
}

function barChartPercentOneDecimalTooltipContentEditor(str, seriesIndex, pointIndex, plot) {
  
  var result = "" + plot.data[seriesIndex][pointIndex];
  if (result.indexOf(".") === -1) {
    return result + ".0";
  }
  return addCommas(result);
}

function barChartNoPercentTooltipContentEditor(str, seriesIndex, pointIndex, plot) {

  var result = plot.data[seriesIndex][pointIndex];
  return addCommas(result);
}

function addCommas(nStr) {
  nStr += '';
  var x = nStr.split('.');
  var x1 = x[0];
  var x2 = x.length > 1 ? '.' + x[1] : '';
  var rgx = /(\d+)(\d{3})/;
  while (rgx.test(x1)) {
    x1 = x1.replace(rgx, '$1' + ',' + '$2');
  }
  return x1 + x2;
}

function barChartShowPercentTooltipContentEditor(str, seriesIndex, pointIndex, plot) {

  var result = plot.data[seriesIndex][pointIndex];
  result = addCommas(result);
  return result + "%";
}


function timerIncrement() {
  idleTime = idleTime + 1;

  //Logout the page if idle time is longer than 30 minutes (1800 seconds).
  //This time need to be the same as the session-timeout in web.xml.
  if (idleTime > 1800) {
    $("#logout-header-form\\:logoutButton").click();
  }
}

function resetTimer() {
  idleTime = 0;
}

function changeTabDynamic(tabId)
{
  $('#main-page-tabForm\\:main-page-tabView ul li a[href="#main-page-tabForm:main-page-tabView:' + tabId + '"]').click();
}


function lineChartTooltipContentEditor(str, seriesIndex, pointIndex, plot) {

  var amount = str.substring(str.indexOf(",") + 1, str.length);
  amount = addCommas(amount);
  return amount;
}

function lineChartOneDecimalTooltipContentEditor(str, seriesIndex, pointIndex, plot) {

  var res = str.split(",");
  var inte = parseInt(res[0], 10);
  var strx = "" + plot.data[seriesIndex][inte - 1];
  var dem = strx.split(",");
  if (dem[1].indexOf(".") === -1) {
    return dem[1] + ".0";
  }
  return addCommas(dem[1]);
}

function lineChartOneDecimalPercentageTooltipContentEditor(str, seriesIndex, pointIndex, plot) {

  var res = str.split(",");
  var inte = parseInt(res[0], 10);
  var strx = "" + plot.data[seriesIndex][inte - 1];
  var dem = strx.split(",");
  if (dem[1].indexOf(".") === -1) {
    return dem[1] + ".0%";
  }
  return dem[1] + "%";
}

function barChartExtender() {

  this.cfg.grid = {
    background: 'transparent',
    drawBorder: false,
    shadow: false
  };

  this.cfg.highlighter.tooltipLocation = 'n';
  this.cfg.axes.xaxis.drawBaseline = true;
  this.cfg.axes.xaxis.tickOptions.showMark = false;
  this.cfg.axes.xaxis.tickOptions.showGridline = false;
  this.cfg.axes.xaxis.tickOptions.fontFamily = 'JLREmericWeb-ExtraLight';

  this.cfg.axes.xaxis.labelOptions = {
    fontFamily: 'JLREmericWeb-ExtraLight'
  };

  this.cfg.axes.yaxis.tickOptions.showMark = false;
  this.cfg.axes.yaxis.tickOptions.showGridline = false;
  this.cfg.axes.yaxis.tickOptions.fontFamily = 'JLREmericWeb-ExtraLight';

  this.cfg.axes.yaxis.labelOptions = {
    fontFamily: 'JLREmericWeb-ExtraLight'
  };
}

function horizontalBarChartExtender() {

  this.cfg.grid = {
    background: 'transparent',
    drawBorder: false,
    shadow: false
  };

  this.cfg.highlighter = {

    tooltipContentEditor: function (str, seriesIndex, pointIndex, plot) {
      var series = plot.data[seriesIndex];
      var total = 0;
      series.forEach(function (entry) {
        total = total + entry[0];
      });

      var percent = Math.round((plot.data[seriesIndex][pointIndex][0] / total) * 100) + "%";
      return plot.data[seriesIndex][pointIndex][0] + ', ' + percent;
    },
    show: true,
    tooltipLocation: 'e'
  };

  this.cfg.seriesDefaults.rendererOptions.varyBarColor = true;

  this.cfg.axes.xaxis.drawBaseline = true;
  this.cfg.axes.xaxis.tickOptions.showMark = false;
  this.cfg.axes.xaxis.tickOptions.showGridline = false;
  this.cfg.axes.xaxis.tickOptions.fontFamily = 'JLREmericWeb-ExtraLight';

  this.cfg.axes.xaxis.labelOptions = {
    fontFamily: 'JLREmericWeb-ExtraLight'
  };

  this.cfg.axes.yaxis.tickOptions.showMark = false;
  this.cfg.axes.yaxis.tickOptions.showGridline = false;
  this.cfg.axes.yaxis.tickOptions.fontFamily = 'JLREmericWeb-ExtraLight';

  this.cfg.axes.yaxis.labelOptions = {
    fontFamily: 'JLREmericWeb-ExtraLight'
  };
}

function lineChartExtender() {
  this.cfg.grid = {
    background: 'transparent',
    drawBorder: false,
    shadow: false
  };

  this.cfg.seriesDefaults.rendererOptions.varyBarColor = true;

  this.cfg.axes.xaxis.drawBaseline = true;
  this.cfg.axes.xaxis.tickOptions.showMark = false;
  this.cfg.axes.xaxis.tickOptions.showGridline = false;
  this.cfg.axes.xaxis.tickOptions.fontFamily = 'JLREmericWeb-ExtraLight';

  this.cfg.axes.xaxis.labelOptions = {
    fontFamily: 'JLREmericWeb-ExtraLight'
  };

  this.cfg.axes.yaxis.tickOptions.showMark = false;
  this.cfg.axes.yaxis.tickOptions.showGridline = false;
  this.cfg.axes.yaxis.tickOptions.fontFamily = 'JLREmericWeb-ExtraLight';

  this.cfg.axes.yaxis.labelOptions = {
    fontFamily: 'JLREmericWeb-ExtraLight'
  };
}

function lineChartExtenderWithLegend() {
  this.cfg.grid = {
    background: 'transparent',
    drawBorder: false,
    shadow: false
  };

  this.cfg.seriesDefaults.rendererOptions.varyBarColor = true;

  this.cfg.axes.xaxis.drawBaseline = true;
  this.cfg.axes.xaxis.tickOptions.showMark = false;
  this.cfg.axes.xaxis.tickOptions.showGridline = false;
  this.cfg.axes.xaxis.tickOptions.fontFamily = 'JLREmericWeb-ExtraLight';

  this.cfg.axes.xaxis.labelOptions = {
    fontFamily: 'JLREmericWeb-ExtraLight'
  };

  this.cfg.axes.yaxis.tickOptions.showMark = false;
  this.cfg.axes.yaxis.tickOptions.showGridline = false;
  this.cfg.axes.yaxis.tickOptions.fontFamily = 'JLREmericWeb-ExtraLight';

  this.cfg.axes.yaxis.labelOptions = {
    fontFamily: 'JLREmericWeb-ExtraLight'
  };

  this.cfg.legend = {
    renderer: $.jqplot.EnhancedLegendRenderer,
    show: true,
    location: 'e',
    border: 'transparent',
    placement: 'outsideGrid'
  };
}

function donutChartExtender() {

  this.cfg.grid = {
    background: 'transparent',
    drawBorder: false,
    shadow: false,
    gridDimensions: {height: 300, width: 400}
  };

  this.cfg.legend = {
    renderer: $.jqplot.EnhancedLegendRenderer,
    show: true,
    location: 'e',
    border: 'transparent'
  };

  this.cfg.seriesDefaults = {
    shadow: false,
    renderer: $.jqplot.DonutRenderer,
    rendererOptions: {
      thickness: 24,
      dataLabelNudge: 32,
      sliceMargin: 1,
      dataLabels: 'percent',
      showDataLabels: true
    }
  };
}

function donutChartExtenderEmpty() {

  this.cfg.grid = {
    background: 'transparent',
    drawBorder: false,
    shadow: false,
    gridDimensions: {height: 300, width: 400}
  };

  this.cfg.legend = {
    renderer: $.jqplot.EnhancedLegendRenderer,
    show: true,
    location: 'e',
    border: 'transparent'
  };

  this.cfg.seriesDefaults = {
    shadow: false,
    renderer: $.jqplot.DonutRenderer,
    rendererOptions: {
      fill: false,
      thickness: 24,
      sliceMargin: 2
    }
  };
}
